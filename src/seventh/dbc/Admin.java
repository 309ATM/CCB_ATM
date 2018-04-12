package seventh.dbc;

public class Admin {
		private String adminId;
		private String passwd;
		public String getAdminId() {
			return adminId;
		}
		public void setAdminId(String adminId) {
			this.adminId = adminId;
		}
		public String getPasswd() {
			return passwd;
		}
		public void setPasswd(String passwd) {
			this.passwd = passwd;
		}
		@Override
		public String toString() {
			return "admin [adminId=" + adminId + ", passwd=" + passwd + "]";
		}
	}

