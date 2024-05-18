class DatabaseConnection {
        private static DatabaseConnection instance;

        private DatabaseConnection() {
            // private constructor
        }

        public static synchronized DatabaseConnection getInstance() {
            if (instance == null) {
                instance = new DatabaseConnection();
            }
            return instance;
        }

        public void connect() {
            // connection code
        }
}
