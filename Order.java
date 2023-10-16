package task1_4;

import java.util.Arrays;
import java.util.Comparator;

public class Order {
	private OrderItem[] items;

	public Order(OrderItem[] items) {
		super();
		this.items = items;
	}

// phương thức tính tổng tiền hóa đơn
	public double cost() {
		int totalCost = 0;
		for (int i = 0; i < items.length; i++) {
			totalCost += items[i].getP().getPrice() * items[i].getQuality();
		}
		return totalCost;
	}

// phương thức kiểm tra một săn phẩm có trong danh sách order hay không.
	public boolean contains(Product p) {
		// Comparator dùng để chỉ định tiêu chí để sort mảng các sản phẩm order.
//		Arrays.sort(items, new Comparator<OrderItem>() {
//			@Override
//			public int compare(OrderItem o1, OrderItem o2) {
//				// TODO Auto-generated method stub
//				return o1.compareTo(o2);
//			}
//		});
		quickSort(items);
		return searchBinary(p, 0, items.length - 1);
	}
	
	public static void quickSort(OrderItem[] arr) {
		quickSortSupport(arr, 0, arr.length - 1);
	}

	public static void quickSortSupport(OrderItem[] arr, int start, int end) {
		if (start > end)
			return;
		int pivot = partition(arr, start, end);

		quickSortSupport(arr, start, pivot - 1);
		quickSortSupport(arr, pivot + 1, end);
	}

	public static int partition(OrderItem[] arr, int start, int end) {
		Product pivot = arr[end].getP();
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (arr[j].compare(pivot) > 0) {
				i++;
				swap(arr, i, j);
			}
		}
		i++;
		swap(arr, end, i);
		return i;
	}
	public static void swap(OrderItem[] array, int i, int j) {
		OrderItem temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

// phương thức bổ trợ tìm kiếm nhị phân một sản phẩm trong danh sách order.
	// phương thức được triển khai theo cách tìm kiếm nhị phân đệ quy.
	public boolean searchBinary(Product target, int start, int end) {
		if (start > end)
			return false;
		int mid = (start + end) / 2;
		int compare = items[mid].compare(target);
		if (compare == 0)
			return true;
		if (compare < 0) {
			return searchBinary(target, start, mid - 1);
		} else {
			return searchBinary(target, mid + 1, end);
		}
	}

// phương thức lọc các sản phẩm có cùng loại được chỉ định.
	public Product[] filter(String type) {
		// tạo một mảng các giá trị boolean để đánh dấu các phần tử có loại "type" trong
		// mảng
		// với các sản phẩm có loại "type" sẽ được đánh dấu là true và ngược lại là
		// false.
		boolean[] listNode = new boolean[items.length];
		int count = 0;
		for (int i = 0; i < listNode.length; i++) {
			if (items[i].getP().getType().equals(type)) {
				listNode[i] = true;
				count++;
			} else
				listNode[i] = false;
		}
		// Dựa vào số lượng các sản phẩm được đánh dấu để lập một mảng chứa các sản phẩm
		// có loại "type".
		Product[] filterProduct = new Product[count];
		count = 0;
		for (int i = 0; i < listNode.length; i++) {
			if (listNode[i] == true) {
				filterProduct[count++] = items[i].getP();
			}
		}
		return filterProduct;
	}

	public static void main(String[] args) {
		Product product1 = new Product("01", "Banh", 10.0, "Snack");
		Product product2 = new Product("02", "Nuoc Ngot", 5.0, "Drink");
		Product product3 = new Product("03", "Keo", 12.0, "Candy");
		Product product4 = new Product("01", "Banh", 15.0, "Snack");
		OrderItem[] o = { new OrderItem(product1, 2), new OrderItem(product2, 3), new OrderItem(product3, 5),
				new OrderItem(product4, 6) };
		Order myOrder = new Order(o);
		System.out.println(myOrder.contains(product4));
		System.out.println(Arrays.toString(myOrder.filter("Snack")));
	}
}