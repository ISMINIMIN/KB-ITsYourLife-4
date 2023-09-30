package 트리;

public class TreeExam {
	
	static class Node<K, V> {
		private K key;
		private V value;
		private Node<K, V> left;
		private Node<K, V> right;
		
		public Node(K key, V value, Node<K, V> left, Node<K, V> right) {
			super();
			this.key = key;
			this.value = value;
			this.left = left;
			this.right = right;
		}
		
		public Node(K key, V value) {
			this(key, value, null, null);
		}
		
		public K getKey() {
			return key;
		}
		
		public V getValue() {
			return value;
		}
		
		@Override
		public String toString() {
			return "K : " + key + ", V : " + value + ", LEFT : " + left + ", RIGHT : " + right;
		}
	}
	
	public static void main(String[] args) {
		Node<String, Integer> node = new Node<>("홍길동", 90);
		System.out.println(node);
	}
}
