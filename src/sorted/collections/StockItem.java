package sorted.collections;

public class StockItem implements Comparable<StockItem> {

	private final String name;
	private double price;
	private int quantityStock = 0; // can be initialized later
	private int reserved;

	public StockItem(String name, double price) {
		this.name = name;
		this.price = price;
		this.quantityStock = 0; // or here (but you wouln't normally do both)
	}

	public StockItem(String name, double price, int quantityStock) {
		this.name = name;
		this.price = price;
		this.quantityStock = quantityStock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price > 0.0) {
			this.price = price;
		}
	}

	public int availableQuantity() {
		return quantityStock - reserved;
	}

	public void setQuantityStock(int quantityStock) {
		this.quantityStock = quantityStock;
	}

	public String getName() {
		return name;
	}

	public void adjustStock(int quantity) {
		int newQuantity = this.quantityStock + quantity;
		if (newQuantity >= 0) {
			this.quantityStock = newQuantity;
		}
	}
	
	public int reserveStock(int quantity) {
		if(quantity <= availableQuantity()) {
			reserved += quantity;
			return quantity;
		}
		return 0;
	}
	
	public int unreserveStock(int quantity) {
		if(quantity <= reserved) {
			reserved -= quantity;
			return quantity;
		}
		return 0;
	}
	
    public int finaliseStock(int quantity) {
        if (quantity <= reserved) {
        	quantityStock -= quantity;
            reserved -= quantity;
            return quantity;
        }

        return 0;
    }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockItem other = (StockItem) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(StockItem o) {
//		System.out.println("Entering StockItem.compareTo");
		if(this == o) {
			return 0;
		}
		if(o != null) {
			return this.name.compareTo(o.getName());
		}
		
		throw new NullPointerException();
	}

    @Override
    public String toString() {
        return this.name + " : price " + this.price + ". Reserved: " + this.reserved;
    }

}
