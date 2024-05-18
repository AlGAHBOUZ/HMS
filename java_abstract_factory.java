// Abstract class: MedicalSupply
public abstract class MedicalSupply {
        public abstract Bandages supplyBandages();
        public abstract Medicine supplyMedicine();
        public abstract Anesthesia supplyAnesthesia();
        public abstract Gloves supplyGloves();
        public abstract FaceMasks supplyFaceMasks();
        public abstract Syringes supplySyringes();
        public abstract Alcohol supplyAlcohol();
}

// Concrete class for Supplier X
public class SupplierX extends MedicalSupply {
@Override
        public Bandages supplyBandages() {
    return new SupplierXBandages();
}

@Override
        public Medicine supplyMedicine() {
    return new SupplierXMedicine();
}

@Override
        public Anesthesia supplyAnesthesia() {
    return new SupplierXAnesthesia();
}

@Override
        public Gloves supplyGloves() {
    return new SupplierXGloves();
}

@Override
        public FaceMasks supplyFaceMasks() {
    return new SupplierXFaceMasks();
}

@Override
        public Syringes supplySyringes() {
    return new SupplierXSyringes();
}

@Override
        public Alcohol supplyAlcohol() {
    return new SupplierXAlcohol();
}
}

// Concrete class for Supplier Y
public class SupplierY extends MedicalSupply {
@Override
        public Bandages supplyBandages() {
    return new SupplierYBandages();
}

@Override
        public Medicine supplyMedicine() {
    return new SupplierYMedicine();
}

@Override
        public Anesthesia supplyAnesthesia() {
    return new SupplierYAnesthesia();
}

@Override
        public Gloves supplyGloves() {
    return new SupplierYGloves();
}

@Override
        public FaceMasks supplyFaceMasks() {
    return new SupplierYFaceMasks();
}

@Override
        public Syringes supplySyringes() {
    return new SupplierYSyringes();
}

@Override
        public Alcohol supplyAlcohol() {
    return new SupplierYAlcohol();
}
}

// Abstract product: Bandages
public abstract class Bandages {}

// Concrete products for Supplier X
class SupplierXBandages extends Bandages {}

// Concrete products for Supplier Y
class SupplierYBandages extends Bandages {}

// Abstract product: Medicine
public abstract class Medicine {}

// Concrete products for Supplier X
class SupplierXMedicine extends Medicine {}

// Concrete products for Supplier Y
class SupplierYMedicine extends Medicine {}

// Abstract product: Anesthesia
public abstract class Anesthesia {}

// Concrete products for Supplier X
class SupplierXAnesthesia extends Anesthesia {}

// Concrete products for Supplier Y
class SupplierYAnesthesia extends Anesthesia {}

// Abstract product: Gloves
public abstract class Gloves {}

// Concrete products for Supplier X
class SupplierXGloves extends Gloves {}

// Concrete products for Supplier Y
class SupplierYGloves extends Gloves {}

// Abstract product: Face Masks
public abstract class FaceMasks {}

// Concrete products for Supplier X
class SupplierXFaceMasks extends FaceMasks {}

// Concrete products for Supplier Y
class SupplierYFaceMasks extends FaceMasks {}

// Abstract product: Syringes
public abstract class Syringes {}

// Concrete products for Supplier X
class SupplierXSyringes extends Syringes {}

// Concrete products for Supplier Y
class SupplierYSyringes extends Syringes {}

// Abstract product: Alcohol
public abstract class Alcohol {}

// Concrete products for Supplier X
class SupplierXAlcohol extends Alcohol {}

// Concrete products for Supplier Y
class SupplierYAlcohol extends Alcohol {}
