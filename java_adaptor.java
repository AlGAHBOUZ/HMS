// Target Interface
public interface DocumentParser {
void parseDocument();
}

// Adaptee
public class MobileScanner {
public void scanDocument() {
    System.out.println("Scanning document using mobile scanner.");
    // Logic for scanning document
}
}

// Adapter
public class MobileScannerAdapter implements DocumentParser {
private MobileScanner scanner;

public MobileScannerAdapter(MobileScanner scanner) {
    this.scanner = scanner;
}

@Override
        public void parseDocument() {
    scanner.scanDocument();
    System.out.println("Converting scanned document into usable data.");
    // Logic for converting scanned document into usable data
}
}

class System {
        public static void main(String[] args) {
            // Using the adapter to parse scanned documents
            DocumentParser parser = new MobileScannerAdapter(new MobileScanner());
            parser.parseDocument();
        }
}