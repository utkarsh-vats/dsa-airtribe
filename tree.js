class Node {
	constructor(value, left = null, right = null) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
}

class Tree {}

Tree.prototype.levelOrder = function (root) {
	let queue = new Array();
	queue.push(root);
	let result = new Array();
	while (queue.length > 0) {
		let curr = queue.shift();
		result.push(curr);
		if (curr.left) {
			queue.push(curr.left);
		}
		if (curr.right) {
			queue.push(curr.right);
		}
	}
	return result;
};

Tree.prototype.levelWiseLevelOrder = function (root) {
	let queue = new Array();
	queue.push(root);
	let result = new Array(); // Array<Array<Node>>

	while (queue.length > 0) {
		let size = queue.length;
		let level = new Array();

		while (size-- > 0) {
			let curr = queue.shift();
			level.push(curr);
			if (curr.left) {
				queue.push(curr.left);
			}
			if (curr.right) {
				queue.push(curr.right);
			}
		}
		result.push(level);
	}
	return result;
};

Tree.prototype.zigZagOrder = function (root) {
	let levelOrder = this.levelWiseLevelOrder(root);
	let result = new Array();
	for (let i = 0; i < levelOrder.length; i++) {
		let level = levelOrder[i];
		if (i % 2 === 0) {
			result.push(level);
		} else {
			result.push(level.reverse());
		}
	}
	return result;
};

Tree.prototype.leftView = function (root) {
	let levelOrder = this.levelWiseLevelOrder(root);
	let result = new Array();
	for (let i = 0; i < levelOrder.length; i++) {
		let level = levelOrder[i];
		result.push(level[0]);
	}
	return result;
};

Tree.prototype.rightView = function (root) {
	let levelOrder = this.levelWiseLevelOrder(root);
	let result = new Array();
	for (let i = 0; i < levelOrder.length; i++) {
		let level = levelOrder[i];
		result.push(level[level.length - 1]);
	}
	return result;
};

let t = new Tree();
let root = new Node(1);
let n1 = new Node(2);
let n2 = new Node(3);
let n3 = new Node(4);
let n4 = new Node(5);
let n5 = new Node(6);
let n6 = new Node(7);
root.left = n1;
root.right = n2;
n1.left = n3;
n1.right = n4;
n2.left = n5;
n5.right = n6;
console.log("Level Order: ", t.levelOrder(root));
console.log("Level Wise Level Order: ", t.levelWiseLevelOrder(root));
console.log("Zig Zag Order: ", t.zigZagOrder(root));
console.log("Left View: ", t.leftView(root));
console.log("Right View: ", t.rightView(root));
