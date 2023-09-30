package 트리;

import java.util.Comparator;

public class BinTree<K, V> {
	


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
	} // end Node
	
	private Node<K, V> root;
	private Comparator<? super K> comparator; // K를 상속받은 모든 타입 비교하는 비교기

	private void add(K key, V value) {
		if(root == null) {
			root = new Node<K, V>(key, value);
		} else {
			addNode(root, key, value);
		}
	} // end add

	private void addNode(Node<K, V> node, K key, V value) {
		// node의 키 값보다 작으면 LEFT, 아니면 RIGHT에 저장
		int condition = comp(key, node.getKey());
		if(condition == 0) return;
		if(condition < 0) { // 왼쪽에 저장
			if(node.left == null) node.left = new Node<K, V>(key, value);
			else addNode(node.left, key, value);
		} else { // 오른쪽에 저장
			if(node.right == null) node.right = new Node<K, V>(key, value);
			else addNode(node.right, key, value);
		}
	} // end addNode

	private int comp(K key1, K key2) {
		return (comparator == null) ? ((Comparable<K>) key1).compareTo(key2) : comparator.compare(key1, key2);
	}
	
	public static void main(String[] args) {
		BinTree<Integer, String> binTree = new BinTree<>();
		
		// 등록
		Node<Integer, String> node = new Node<>(1, "홍길동");
		binTree.add(node.getKey(), node.getValue());
		
		node = new Node<>(3, "김길동");
		binTree.add(node.getKey(), node.getValue());
		
		node = new Node<>(2, "박길동");
		binTree.add(node.getKey(), node.getValue());
	}
	
}
