interface Observer {
        void update(String message);
}

interface Subject {
        void registerObserver(Observer observer);
        void removeObserver(Observer observer);
        void notifyObservers();
}

class Supplier implements Subject {
        private List<Observer> observers = new ArrayList<>();
        private String latestUpdate;

        public void setLatestUpdate(String latestUpdate) {
            this.latestUpdate = latestUpdate;
            notifyObservers();
        }

        @Override
        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void removeObserver(Observer observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(latestUpdate);
            }
        }
}

class Hospital implements Observer {
        private String name;

        public Hospital(String name) {
            this.name = name;
        }

        @Override
        public void update(String message) {
            System.out.println("Hospital " + name + " received update: " + message);
        }
}
