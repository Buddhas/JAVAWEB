 public  String inserPicture(HttpServletRequest request,@RequestParam(value="album",required = false)MultipartFile[] album){
		    	
		    	String connectId=request.getParameter("empNo");
		    	//图片上传
		        if(album != null) {
		          	 //上传图片
		              //文件上传根目录
		              String path = request.getSession().getServletContext().getRealPath("/");
		             
		              //上传路径
		              String filePath = path +  File.separator + "upload\\image\\";
		           for (int i = 0; i < album.length; i++) {
		               if (album[i].getOriginalFilename() == "")
		                   continue;
		               String OriginalFilename = album[i].getOriginalFilename();
		               String lastname = OriginalFilename.substring(OriginalFilename.lastIndexOf("."));
		               // 文件名：
		               String pictureId = IDGenerator.genId();
		               String fileName = pictureId + lastname;
		               fileName.replaceAll(" ", "");
		               // 文件名： 长度255
		               if (fileName.length() > 255) {
		                   fileName = fileName.substring(0, 254);
		               }
		               File file = new File(filePath, fileName);
		               if (!file.exists()) {
		                   file.mkdirs();
		               }
		               try {
		                   album[i].transferTo(file);
		                   saveMessage(request,"图片上传成功");
		               } catch (Exception e) {
		                   saveError(request, "图片上传失败");
		                   e.printStackTrace();
		               } 
		               Picture picture = new Picture();
		               picture.setPicId(pictureId);
		               picture.setConnectId(connectId);  //为图片设置关联。
		               
		               String picpath = "http://" + request.getServerName() //服务器地址  
	                    + ":"   
	                    + request.getServerPort()    //端口号  
	                    + request.getContextPath() //项目名称
	                    + "/upload/image/"
	                    + fileName;     
	
		               picture.setPicPath(picpath);
		               pictureDao.insertPicture(picture);
		               
		               tPersonalInfo record = tPersonalInfoManager.listByEmpNo(Long.valueOf(connectId));
		               record.setPicturePath(picpath);
		               tPersonalInfoManager.updateByPrimaryKeySelective(record);
		           }
		         }
		    	return "redirect:/tPersonalInfoManager/tPersonalInfo/personalInsert";
		    }