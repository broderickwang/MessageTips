package marc.com.messagetips.Bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Broderick on 2017/1/6.
 */

public class JsonBean {
	/**
	 * code : 0
	 * data : {"data":[{"no":"413be46a6e8db877","name":"测试删除","image":"6b730bb059b780a0/9c8200d60bde211d.png","newCarPrice":0,"salePrice":2,"firstPlate":1483027200,"mileage":1},{"no":"514d848d8495716b","name":"宝马二手车九成新","image":"6b730bb059b780a0/7f8f209890cc1631.png","newCarPrice":0,"salePrice":35,"firstPlate":1480550400,"mileage":1},{"no":"qd-138708","name":"起亚-K4 2014款 1.8L 自动GLS","image":"https://img2.rrcimg.com/o_1b4bj8hcl2491359902357974622056092.jpg?imageView2/2/interlace/1/w/290/h/192/format/webp","newCarPrice":14.9,"salePrice":11.86,"firstPlate":1446307200,"mileage":1.16},{"no":"qd-138753","name":"别克-GL8 2014款 2.4L 经典版","image":"https://img2.rrcimg.com/o_1b4bgen4r25935575614524561514373.jpg?imageView2/2/interlace/1/w/290/h/192/format/webp","newCarPrice":20.9,"salePrice":16,"firstPlate":1427817600,"mileage":6.3},{"no":"qd-138679","name":"福特-蒙迪欧-致胜 2011款 2.0L GTDi200时尚型","image":"https://img2.rrcimg.com/o_1b4b945g15027410694332194136418523.jpg?imageView2/2/interlace/1/w/290/h/192/format/webp","newCarPrice":200,"salePrice":10.68,"firstPlate":1343750400,"mileage":4.7},{"no":"qd-138737","name":"福特-翼搏 2013款 1.5L 手动舒适型","image":"https://img2.rrcimg.com/o_1b4b30iod549464996324193558946320.jpg?imageView2/2/interlace/1/w/290/h/192/format/webp","newCarPrice":9.5,"salePrice":6.68,"firstPlate":1414771200,"mileage":2.13},{"no":"qd-137535","name":"现代-朗动 2015款 1.6L 自动时尚型","image":"https://img2.rrcimg.com/o_1b3p9p8a7203009945293901891825190.jpg?imageView2/2/interlace/1/w/290/h/192/format/webp","newCarPrice":11.6,"salePrice":8.25,"firstPlate":1431273600,"mileage":1.82},{"no":"qd-137977","name":"北京-BJ40 2014款 2.4L 手动拓疆版","image":"https://img2.rrcimg.com/o_1b3ugivuc5582855578393943351154281.jpg?imageView2/2/interlace/1/w/290/h/192/format/webp","newCarPrice":17.7,"salePrice":10.3,"firstPlate":1396281600,"mileage":3.53}],"paging":{"pageNo":0,"pageSize":20,"pageCount":1,"totalRecordCount":6}}
	 * message : success
	 */

	private int code;
	/**
	 * data : [{"no":"413be46a6e8db877","name":"测试删除","image":"6b730bb059b780a0/9c8200d60bde211d.png","newCarPrice":0,"salePrice":2,"firstPlate":1483027200,"mileage":1},{"no":"514d848d8495716b","name":"宝马二手车九成新","image":"6b730bb059b780a0/7f8f209890cc1631.png","newCarPrice":0,"salePrice":35,"firstPlate":1480550400,"mileage":1},{"no":"qd-138708","name":"起亚-K4 2014款 1.8L 自动GLS","image":"https://img2.rrcimg.com/o_1b4bj8hcl2491359902357974622056092.jpg?imageView2/2/interlace/1/w/290/h/192/format/webp","newCarPrice":14.9,"salePrice":11.86,"firstPlate":1446307200,"mileage":1.16},{"no":"qd-138753","name":"别克-GL8 2014款 2.4L 经典版","image":"https://img2.rrcimg.com/o_1b4bgen4r25935575614524561514373.jpg?imageView2/2/interlace/1/w/290/h/192/format/webp","newCarPrice":20.9,"salePrice":16,"firstPlate":1427817600,"mileage":6.3},{"no":"qd-138679","name":"福特-蒙迪欧-致胜 2011款 2.0L GTDi200时尚型","image":"https://img2.rrcimg.com/o_1b4b945g15027410694332194136418523.jpg?imageView2/2/interlace/1/w/290/h/192/format/webp","newCarPrice":200,"salePrice":10.68,"firstPlate":1343750400,"mileage":4.7},{"no":"qd-138737","name":"福特-翼搏 2013款 1.5L 手动舒适型","image":"https://img2.rrcimg.com/o_1b4b30iod549464996324193558946320.jpg?imageView2/2/interlace/1/w/290/h/192/format/webp","newCarPrice":9.5,"salePrice":6.68,"firstPlate":1414771200,"mileage":2.13},{"no":"qd-137535","name":"现代-朗动 2015款 1.6L 自动时尚型","image":"https://img2.rrcimg.com/o_1b3p9p8a7203009945293901891825190.jpg?imageView2/2/interlace/1/w/290/h/192/format/webp","newCarPrice":11.6,"salePrice":8.25,"firstPlate":1431273600,"mileage":1.82},{"no":"qd-137977","name":"北京-BJ40 2014款 2.4L 手动拓疆版","image":"https://img2.rrcimg.com/o_1b3ugivuc5582855578393943351154281.jpg?imageView2/2/interlace/1/w/290/h/192/format/webp","newCarPrice":17.7,"salePrice":10.3,"firstPlate":1396281600,"mileage":3.53}]
	 * paging : {"pageNo":0,"pageSize":20,"pageCount":1,"totalRecordCount":6}
	 */

	private DataBean data;
	private String message;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public DataBean getData() {
		return data;
	}

	public void setData(DataBean data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static class DataBean {
		/**
		 * pageNo : 0
		 * pageSize : 20
		 * pageCount : 1
		 * totalRecordCount : 6
		 */

		@SerializedName("paging")
		private PagingBean pagedata;
		/**
		 * no : 413be46a6e8db877
		 * name : 测试删除
		 * image : 6b730bb059b780a0/9c8200d60bde211d.png
		 * newCarPrice : 0.0
		 * salePrice : 2.0
		 * firstPlate : 1483027200
		 * mileage : 1.0
		 */

		@SerializedName("data")
		private List<CarBean> cardata;

		public PagingBean getPagedata() {
			return pagedata;
		}

		public void setPagedata(PagingBean pagedata) {
			this.pagedata = pagedata;
		}

		public List<CarBean> getCardata() {
			return cardata;
		}

		public void setCardata(List<CarBean> cardata) {
			this.cardata = cardata;
		}

		public static class PagingBean {
			private int pageNo;
			private int pageSize;
			private int pageCount;
			private int totalRecordCount;

			public int getPageNo() {
				return pageNo;
			}

			public void setPageNo(int pageNo) {
				this.pageNo = pageNo;
			}

			public int getPageSize() {
				return pageSize;
			}

			public void setPageSize(int pageSize) {
				this.pageSize = pageSize;
			}

			public int getPageCount() {
				return pageCount;
			}

			public void setPageCount(int pageCount) {
				this.pageCount = pageCount;
			}

			public int getTotalRecordCount() {
				return totalRecordCount;
			}

			public void setTotalRecordCount(int totalRecordCount) {
				this.totalRecordCount = totalRecordCount;
			}
		}

		public static class CarBean {
			private String no;
			private String name;
			private String image;
			private double newCarPrice;
			private double salePrice;
			private int firstPlate;
			private double mileage;

			public String getNo() {
				return no;
			}

			public void setNo(String no) {
				this.no = no;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getImage() {
				return image;
			}

			public void setImage(String image) {
				this.image = image;
			}

			public double getNewCarPrice() {
				return newCarPrice;
			}

			public void setNewCarPrice(double newCarPrice) {
				this.newCarPrice = newCarPrice;
			}

			public double getSalePrice() {
				return salePrice;
			}

			public void setSalePrice(double salePrice) {
				this.salePrice = salePrice;
			}

			public int getFirstPlate() {
				return firstPlate;
			}

			public void setFirstPlate(int firstPlate) {
				this.firstPlate = firstPlate;
			}

			public double getMileage() {
				return mileage;
			}

			public void setMileage(double mileage) {
				this.mileage = mileage;
			}
		}
	}
}
