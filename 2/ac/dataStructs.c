#include <stdlib.h>
#include <stdio.h>
typedef struct btree{
	int value;
	struct btree *left ,*right;
}Node, *BTree;

int size(BTree a){

	if (!a) return 0;
 	
	return 1 + size(a->left) + size(a->right);
}

int main(void){
	BTree a, b1, b2, c1,c2,c3,c4;


	a = malloc(sizeof(struct btree));
	a->value = 1;
	b1 = malloc(sizeof(struct btree));
	b1->value = 2;
	b2 = malloc(sizeof(struct btree));
	b2->value = 3;
	c1 = malloc(sizeof(struct btree));
	c1->value = 4;
	c2 = malloc(sizeof(struct btree));
	c2->value = 5;
	c3 = malloc(sizeof(struct btree));
	c3->value = 6;
	c4 = malloc(sizeof(struct btree));
	c4->value = 7;

	a -> left = b1;
	a -> right = b2;
	b1 -> left = c1;
	b1 -> right = c2;
	b2 -> left = c3;
	b2 -> right = c4;
	c1 -> left = NULL;
	c2 -> right = NULL;
	c3 -> left = NULL;
	c4 -> right = NULL; 
	
	int p = size(a);

	printf("%d\n", p);
	return 0;

}