## 线性表

由同类型数据元素构成有序序列的线性结构

| 线性表数组形式                 | 线性表的链式存储           |
|--------------------------------|----------------------------|
| typedef struct LNode *List;    | typedef struct LNode *List; |
| struct LNode{                  | struct LNode{              |
| ElementType Data[MAXSIZE];     | ElementType Data;          |
| int Last;                      | List Next;                 |
| };                             | };                         |
| struct LNode L;                | strucr LNode L;            |
| List PtrL;                     | List PtrL;                 |
| 访问：L.Data[i]或PtrL->Data[i] |                            |

```CPP
//链表的实现
typedef struct LNode *List;
struct LNode{             
	ElementType Data;         
	List Next;                
};                        
	strucr LNode L;           
	List PtrL; 
```

```CPP
//主要操作方法
List MakeRmpty() //初始化一个空线性链表
ElementType FindKth(int k,List L) //根据位序K，返回相应的元素
int Find(ElementType x,List L) //在L中查找x第一次出现的位置
void insert(ElementType x,int i,List L) //在位序i前插入新元素x
void Delete(int i,List L) //删除指定位序i的元素
int Length(List L) //返回线性表L的长度n
```
## 线性表数组形式的操作方法
```C
//初始化函数
List MakeRmpty(){
	List PtrL;
	PtrL=(List)malloc(sizeof(struct LNode));
	PtrL->Last=-1;
	return PtrL;
}
//查找
int Find(ElementType x,List PtrL){
	int i=0;
	while(i<=PtrL->Last&&PtrL->Data[i]!=x)
		i++;
	if(i>PtrL->Last)
		return -1; //未找到
	else 
		return i; //找到
}
//插入
void insert(ElementType x,int i,List PtrL){
	int j;
	if(PtrL->Last==MAXSIZE-1){
		//表空间已满无法插入
		return;
	}
	if(i<1||i>PtrL->Last+2){
		//位置不合法
		return;
	}
	for(j=PtrL->Last;i=i-1;j--)
		PtrL->Data[j+1]=PtrL->Data[j];
	PtrL->Data[i-1]=x;
	PtrL->Last++;
	return;
}
//删除
void Delete(int i,List PtrL){
	int j;
	if(i<1||i>PtrL->Last+1){
		//检查位置是否合法
		return;
	}
	for(j=1;j<PtrL->Last;j++)
		PtrL->Data[j-1]=PtrL->Data[j];
	PtrL->Last--;
	return;
}
```
## 链表的操作
```CPP
//长度	
int Length(List PtrL){
	List p=PtrL; //P指向第一个节点
	int j=0;
	while(p){
	p=p->next;
	j++;
	}
	return j;
}
//按序号查找元素
List FindKth(int k,List PtrL){
	List p=PtrL;
	int i=1;
	while(p!=NULL%%i<k){
	p=p->next;
	i++;
	}
	if(i==k) return p;
	else return NULL;
}
//按值查找元素
List Find(ElementType x,List PtrL){
	List p=PtrL;
	while(p!=NULL&&p->Data!=x)
		p=p->next;
	return p;
}
//插入——找到要插入位置的前一个节点（插入到第i个位置，则i-1为前一个节点）
List Insert(ElementType x,int i,List PtrL){
	List p,s;
	if(i==1){//插入在头节点
		s=(List)malloc(sizeof(struct LNode));
		s->data=x;
		s->next=PtrL;
		return s;
	}
	p=FindKth(i-1,PtrL); //查找插入位置的前一个节点
	if(p==NULL){return NULL;}
	else{
		s=(List)malloc(sizeof(struct LNode));
		s->Data=x;
		s->Next=p->Next;
		p->Next=s;
		return PtrL;
	}
}
//删除——找到第i-1个节点，将指针用free()释放
List Delete(int i,List PtrL){
	List p,s;
	if(i==1){//删除第一个元素
		s=PtrL;
		if(PtrL!=NULL) PtrL=PtrL->Next;
		else return NULL;
		free(s);
		return PtrL;
	}
	p=FindKth(i-1,PtrL);
	if(p==NULL){return NULL;}
	else if(p->Next==NULL){return NULL;}
	else{
	s=p->Next;
	p->Next=s->Next;
	free(s);
	return PtrL;
	}
}
```
## 例题
```C
//将两个递增的单链表合成为一个递增的链表，不开辟空间
linklist *Union(linklist *la,linklist *lb){
	linklist *p,*q,*r,*u;
	p=la->next;q=lb->next;
	r=la; //r为p的直接前趋
	while((p!=NULL)&&(q!=NULL)){
	if(p->data>q->data){
		u=q->next;r->next=q;
		r=q;q->next=p;q=u;
		}else{
			r=p;p=p->next;
		}
	}
	if(q!=NULL) r->next=q;
	return la;
}
```








