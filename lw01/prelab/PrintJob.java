package lw01.prelab;

abstract class PrintJob implements Chargeable {
    private String id;
    private int pages;

    PrintJob (String id, int pages) {
        if (pages <= 0) {
            throw new IllegalArgumentException("Pages can't be negative");
        }
        this.id = id;
        this.pages = pages;
    }

    public String getId() {
        return id;
    }

    public int getPages() {
        return pages;
    }

    @Override 
    public abstract int calculateCharge();

    public int calculateCharge(int copies) {
        if (copies <= 0) {
            throw new IllegalArgumentException("Copies can't be negative");
        }
        return copies * calculateCharge();
    }

    public String label() {
        return "Print";
    }

    public String summary() {
        return id + " | " + label() + " | " + calculateCharge();
    }
} 

class MonoPrint extends PrintJob {
    MonoPrint(String id, int pages) {
        super(id, pages);
    }

    @Override 
    public int calculateCharge() {
        return 500 * getPages();
    }

    @Override 
    public String label() {
        return "Mono";
    }
}

class ColourPrint extends PrintJob {
    ColourPrint(String id, int pages) {
        super(id, pages);
    }

    @Override 
    public int calculateCharge() {
        if (getPages() <= 10) {
            return (getPages() * 1500) + 2000;
        } else {
            return (10 * 1500) + ((getPages() -10) * 1000) + 2000;
        }        
    }

    @Override 
    public String label() {
        return "Colour";
    }
}

