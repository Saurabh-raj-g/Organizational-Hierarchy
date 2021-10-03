//package Starter; 
import java.io.*; 
import java.util.*; 

// Tree node
class Node {
  int id;
  vect list = new vect();
  Linked_list Linkedlist_child = new Linked_list();
  int level;
  Vector<Integer> vv= new Vector<Integer>();
}
//creating Linked_list node
class Linked_node {
	  Linked_node next;
	  //Linked_node previous;
	  Node item;
	  
	}
//creating Linked_list
class Linked_list{
	Linked_node head ;
	Linked_node tail ;
	int length;
	public int linkedlist_size(){
	  return  length;
	}
	public boolean linkedlist_isEmpty(){
	  return length==0;
	}
	public void insertAtLast(Node data){
		Linked_node newlinkednode = new Linked_node();
		newlinkednode.item = data;
	  if(head==null){
	     head=newlinkednode;
	     tail =newlinkednode;
	    
	     length++;
	  }else{
		  tail.next=newlinkednode;
		  tail=tail.next;
		  
		   length++;
	  }
	     
	}
	public Node deleteAtStart(){
		Linked_node temp = head;
		Node ans = null;
		if(head==null){
			return null;
		}
	    else{
			
			ans= temp.item;
		    head = head.next;
		    temp.next= null;
		    
		    length--;
		}
		return ans;
	}
	public void deletelink(int id){
//		if(length==0){
//			return;
//		}
		Linked_node temp = head;
//		Linked_node temp1=head;
//		while(temp!=null){
//			if(temp.item.id==id && temp==head){
//				deleteAtStart();
//			}
//			else if(temp.item.id==id){
//				Linked_node mat=temp.next;
//				temp1.next=mat;
//				temp=null;
//				length--;
//				break;
//			}
//			else{
//				if(temp==head){
//					temp=temp.next;
//				}
//				else{
//					temp=temp.next;
//					temp1=temp1.next;
//				}
//			}
//		}
			
			
		
		
		if(temp!=null){
			if(temp.item.id ==id){
				deleteAtStart();
			}
			else{
				while(temp.next!=null){
					if(temp.item.id ==id){
						break;
					}
					else if(temp.next.item.id !=id){
						temp = temp.next;
					}
					else if(temp.next.item.id ==id){
						break;
					}
					
				}
				Linked_node temp1 = temp;
				 if(temp1.next !=null){
					temp1= temp1.next.next;
				    temp.next= temp1;
				    length--;
				}else{
					temp1 = null;
					length--;
				}
			}
		}
		
	}
	public Node traverse(int index){	
		Linked_node temp = head;
		if(index <= linkedlist_size()&& !linkedlist_isEmpty()){
			if(index!=1){
				for(int i = 1; i<index ; i++){
					temp = temp.next;
				}
			}
		}
		return temp.item;
	}
		 
}

// creating Path node of employee
class Path_node{
	int id ;
	Vector<Integer> path_index_vector = new Vector<Integer>();
	
}
//creating Path vector of employee
class path_vect{
	Path_node[] arr = new Path_node[1];
	int size=0;
	public boolean searchEmployee(int key){
		int index = key%arr.length;
		boolean ans = false ;
		if(arr[index]==null){
			for(int k=0;k<arr.length;k++){
				if(arr[k]!= null){
					if(arr[k].id==key){
						ans=true;
						break;
					}
					else{
						continue;
					}
			    }
		   }
		}
		else {
			if(arr[index].id==key ){
				ans = true;
			}else{
					for(int k=0;k<arr.length;k++){
						if(arr[k]!= null){
							if(arr[k].id==key){
								ans=true;
								break;
							}
							else{
								continue;
							}
					    }
					}
			}
		}
		return ans;
	}
	public Path_node get1(int key){
		int index = key%arr.length;
		Path_node ans =null ;
		if(arr[index]==null){
			for(int k=0;k<arr.length;k++){
				if(arr[k]!= null){
					if(arr[k].id==key){
						ans=arr[k];
						break;
					}
					else{
						continue;
					}
			    }
		   }
		}
		else {
			if(arr[index].id==key ){
				ans = arr[index];
			}else{
					for(int k=0;k<arr.length;k++){
						if(arr[k]!= null){
							if(arr[k].id==key){
								ans=arr[k];
								break;
							}
							else{
								continue;
							}
					    }
					}
			}
		}
		return ans;

	}
	
	public int get2(int key){
		int index = key%arr.length;
		int ans = 0 ;
		if(arr[index]==null){
			for(int k=0;k<arr.length;k++){
				if(arr[k]!= null){
					if(arr[k].id==key){
						ans=k;
						break;
					}
					else{
						continue;
					}
			    }
		   }
		}
		else {
			if(arr[index].id==key ){
				ans = index;
			}else{
					for(int k=0;k<arr.length;k++){
						if(arr[k]!= null){
							if(arr[k].id==key){
								ans=k;
								break;
							}
							else{
								continue;
							}
					    }
					}
			}
		}
		return ans;
	}
	
	public void man1(int k,Path_node kay){
		if(size==arr.length){
			Path_node[] newa = new Path_node[2*arr.length];
			for(int p=0;p<arr.length;p++){
				if(arr[p]!=null){
					int index = arr[p].id%newa.length;
					if(newa[index]!=null){
						for(int q=0;q<newa.length;q++){
							if(newa[q]==null){
								newa[q]=arr[p];
								break;
							}
							else{
								;
							}
						}
					}
					else{
						newa[index]=arr[p];
					}
				}
				
			}
			
			int inde = k%newa.length;
			
			if(newa[inde]!=null){
				for(int q=0;q<newa.length;q++){
					if(newa[q]==null){
						newa[q]=kay;
						break;
					}
					else{
						;
					}
				}
			}
			else{
				newa[inde]=kay;
			}
			size++;
			arr=newa;
		}
		else{
			int index = k%arr.length;
			
			if(arr[index]!=null){
				for(int p=0;p<arr.length;p++){
					if(arr[p]==null){
						arr[p]=kay;
						break;
					}
					else{
						;
					}
				}
			}
			else{
				arr[index]=kay;
			}
			size++;
		}
	}
	public int path_vect_size(){
		return size;
	}
}
//creating child vector of employee
class vect{
	Node[] arr = new Node[1];
	int size=0;
	public Node get3(int key){
		int index = key%arr.length;
		Node ans =null ;
		if(arr[index]==null){
			for(int k=0;k<arr.length;k++){
				if(arr[k]!= null){
					if(arr[k].id==key){
						ans=arr[k];
						break;
					}
					else{
						continue;
					}
			    }
		   }
		}
		else {
			if(arr[index].id==key ){
				ans = arr[index];
			}else{
					for(int k=0;k<arr.length;k++){
						if(arr[k]!= null){
							if(arr[k].id==key){
								ans=arr[k];
								break;
							}
							else{
								continue;
							}
					    }
					}
			}
		}
		return ans;

	}
	public void man(int k, Node va){
		if(size==arr.length){
			Node[] newa = new Node[2*arr.length];
			for(int p=0;p<arr.length;p++){
				if(arr[p]!=null){
					int index = arr[p].id%newa.length;
					if(newa[index]!=null){
						for(int q=0;q<newa.length;q++){
							if(newa[q]==null){
								newa[q]=arr[p];
							}
							else{
								;
							}
						}
					}
					else{
						newa[index]=arr[p];
					}
				}
				
			}
			
			int inde = k%newa.length;
			
			if(newa[inde]!=null){
				for(int q=0;q<newa.length;q++){
					if(newa[q]==null){
						newa[q]=va;
						break;
					}
					else{
						;
					}
				}
			}
			else{
				newa[inde]=va;
			}
			size++;
			arr=newa;
			
			
		}
		else{
			int index = k%arr.length;
			if(arr[index]!=null){
				for(int p=0;p<arr.length;p++){
					if(arr[p]==null){
						
						arr[p]=va;
						break;
					}
					else{
						;
					}
				}
			}
			else{
				
				arr[index]=va;
			}
			size++;
		}
	}
	public int vect_size(){
		return size;
	}
}
class Tree{
	//root node of the Tree
	Node root1;
	path_vect path = new path_vect();
	int current_size=0;
	public void insert_owner(int key){
		Node let = new Node();
		let.id=key;
		let.level = 1;
		if(root1==null){
			root1=let;
			
			Path_node van = new Path_node();
			van.id=key;
			van.path_index_vector.add(key);
			path.man1(key,van);
		}
		else{
			;
		}
		current_size++;
	}
	public void insert_employee(int id,int bid){
		Path_node lap = path.get1(bid);
		
		Node temp=root1;
		for(int i=0;i<lap.path_index_vector.size();i++){
			if(i==0){
				;
			}
			else{
				temp=temp.list.get3(lap.path_index_vector.get(i));
			}
		}
		
		Vector<Integer> tk = new Vector<Integer>();
		for(int m=0;m<lap.path_index_vector.size();m++){
			tk.add(lap.path_index_vector.get(m));
		}
		tk.add(id);
		
		Node nd = new Node();
		nd.id = id;
		nd.level = Tree_level(bid)+1;
		 
		temp.Linkedlist_child.insertAtLast(nd);
		temp.list.man(id,nd);
		Path_node van = new Path_node();
		van.id=id;
		
		van.path_index_vector=tk;
		path.man1(id,van);
//		
		current_size++;
	}
	
	public int Tree_size(){
		return current_size;
	}
	public boolean Tree_empty(){
		if(current_size==0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public int Tree_level(int key){
		return path.get1(key).path_index_vector.size();
	}
	public void delete_leaf(int key){
		Path_node lap = path.get1(key);
		Vector<Integer> tt = lap.path_index_vector;
		
		
		Node temp=root1;
		for(int i=0;i<tt.size();i++){
			if(i==0){
				;
			}
			else{
					temp=temp.list.get3(tt.get(i));
			}
		}
		Path_node bossnode = path.get1(key);
		int bosid=bossnode.path_index_vector.get(bossnode.path_index_vector.size()-2);
		Path_node lop = path.get1(bosid);
		Vector<Integer> tp = lop.path_index_vector;
		Node temp1=root1;
		for(int i=0;i<tp.size();i++){
			if(i==0){
				;
			}
			else{
				temp1=temp1.list.get3(tp.get(i));
				
			}
		}
		// size changing due to Deleting 
		temp1.Linkedlist_child.deletelink(key);
		temp=null;
		int kk = path.get2(key);
		path.arr[kk]=null;
		temp1.list.size--;
		
		path.size--;
		current_size--;
	}
	public boolean isleaf(int key){
		Path_node lap = path.get1(key);
		Vector<Integer> tt = lap.path_index_vector;
		
		Node temp=root1;
		for(int i=0;i<tt.size();i++){
			if(i==0){
				;
			}
			else{
				temp=temp.list.get3(tt.get(i));
				
			}
		}
		if(temp.Linkedlist_child.linkedlist_isEmpty()){
			return true;
		}
		return false;
	}
	public void delete_employee(int id, int manageId){
		Linked_list Linkedlist_decendent = new Linked_list();
		Path_node lap = path.get1(id);
		Vector<Integer> tt = lap.path_index_vector;
		Node temp=root1;
		
		for(int i=0;i<tt.size();i++){
			if(i==0){
				;
			}
			else{
				
					temp=temp.list.get3(tt.get(i));
			}
		}
		
		Path_node lop = path.get1(manageId);
		Vector<Integer> tp = lop.path_index_vector;
		Node temp1=root1;
		for(int i=0;i<tp.size();i++){
			if(i==0){
				;
			}
			else{
				temp1=temp1.list.get3(tp.get(i));
				
			}
		}
		
		//reducing size of vector of boss
		
		Path_node bossnode = path.get1(id);
		int bosid=bossnode.path_index_vector.get(bossnode.path_index_vector.size()-2);
		Path_node lo = path.get1(bosid);
		Vector<Integer> to = lo.path_index_vector;
		Node tem=root1;
		for(int i=0;i<to.size();i++){
			if(i==0){
				;
			}
			else{
				tem=tem.list.get3(to.get(i));
				
			}
		}	
		tem.Linkedlist_child.deletelink(id);
		int s = path.get2(id);
		path.arr[s]=null;
		path.size--;
		tem.list.size--;
		for(int r=1; r<=temp.Linkedlist_child.linkedlist_size(); r++){
			
			int kk = path.get2(temp.Linkedlist_child.traverse(r).id);
			
			path.arr[kk]=null; 
			path.size--;
	        temp1.list.man(temp.Linkedlist_child.traverse(r).id,temp.Linkedlist_child.traverse(r));
			temp1.Linkedlist_child.insertAtLast(temp.Linkedlist_child.traverse(r));
			//temp1.list.man(temp.Linkedlist_child.traverse(r).id);
			Vector<Integer> tk = new Vector<Integer>();
			for(int m=0;m<lop.path_index_vector.size();m++){
				tk.add(lop.path_index_vector.get(m));
			}
			tk.add(temp.Linkedlist_child.traverse(r).id);
			Path_node van = new Path_node();
			van.id=temp.Linkedlist_child.traverse(r).id;
			
			van.path_index_vector=tk;
			path.man1(temp.Linkedlist_child.traverse(r).id,van);
			//path.arr[kk]=van;
			Linkedlist_decendent.insertAtLast(temp.Linkedlist_child.traverse(r));
		}	
		temp = null;
		
		current_size--;
		int constant_index = 1;
		int u = Linkedlist_decendent.linkedlist_size();
		
		
		while(constant_index ==1 && u!=0){
			if(!Linkedlist_decendent.head.item.Linkedlist_child.linkedlist_isEmpty()){
				Node var = Linkedlist_decendent.traverse(constant_index);
				for(int a =1; a<=var.Linkedlist_child.linkedlist_size();a++){
					int kk = path.get2(var.Linkedlist_child.traverse(a).id);
					path.arr[kk]=null; 
					path.size--;
					Path_node var_pathnode = path.get1(var.id);
					Vector<Integer> tk = new Vector<Integer>();
					for(int m=0;m<var_pathnode.path_index_vector.size();m++){
						tk.add(var_pathnode.path_index_vector.get(m));
					}
					tk.add(var.Linkedlist_child.traverse(a).id);
					Path_node van = new Path_node();
					van.id=var.Linkedlist_child.traverse(a).id;
					
					van.path_index_vector=tk;
					//path.arr[kk]=van;
					path.man1(var.Linkedlist_child.traverse(a).id,van);
					
					Linkedlist_decendent.insertAtLast(var.Linkedlist_child.traverse(a));
					u++;
			    }
				Linkedlist_decendent.deleteAtStart();
				u--;
			}else if(Linkedlist_decendent.head.item.Linkedlist_child.linkedlist_isEmpty()){
				Linkedlist_decendent.deleteAtStart();
				u--;
			}
	   }
		
		
 }
	public int bossId(int id){
		Path_node emp = path.get1(id);
		return emp.path_index_vector.get(emp.path_index_vector.size()-2);
	}
	public int lowestCommonBossId(int id1, int id2){
		Path_node emp1 = path.get1(id1);
		Path_node emp2 = path.get1(id2);
		int result =0;
		if(emp1.path_index_vector.size()<= emp2.path_index_vector.size()){
			int emp1_size= emp1.path_index_vector.size()-2;
			while(emp1_size >=0){
				int emp2_size= emp2.path_index_vector.size()-2;
				int emp_index = 0;
				while(emp2_size>=0){
					if(emp1.path_index_vector.get(emp1_size)==emp2.path_index_vector.get(emp2_size)){
						result= emp1.path_index_vector.get(emp1_size);
						emp_index= emp2_size;
						break;
					}else{
						emp2_size--;
					}
				}
				if(emp1.path_index_vector.get(emp1_size)==emp2.path_index_vector.get(emp_index)){
					break;
				}else{
					emp1_size--;
				}
				
			}
		}else{
			int emp2_size= emp2.path_index_vector.size()-2;
			while(emp2_size >=0){
				int emp1_size= emp1.path_index_vector.size()-2;
				int emp_index = 0;
				while(emp1_size>=0){
					if(emp2.path_index_vector.get(emp2_size)==emp1.path_index_vector.get(emp1_size)){
						result= emp2.path_index_vector.get(emp2_size);
						emp_index= emp1_size;
						break;
					}else{
						emp1_size--;
					}
				}
				if(emp2.path_index_vector.get(emp2_size)==emp1.path_index_vector.get(emp_index)){
					break;
				}else{
					emp2_size--;
				}
				
			}
		}
		return result;

	}
	public boolean haveEmployeeId(int id){
		
		boolean have =path.searchEmployee(id);
		if(have){
			return true;
		}
			return false;
	}
	public String toStringEmplyee(int id){
		Linked_list Linkedlist_decendent = new Linked_list();
		Linked_list Linkedlist_decendent1 = new Linked_list();
		Path_node temp = path.get1(id);
		
		Vector<Integer> tp = temp.path_index_vector;
		Node temp1=root1;
		for(int i=0;i<tp.size();i++){
			if(i==0){
				;
			}
			else{
				temp1=temp1.list.get3(tp.get(i));
				
			}
		}
		//
		Linkedlist_decendent1.insertAtLast(temp1);
		    for(int r=1; r<=temp1.Linkedlist_child.linkedlist_size(); r++){
				Linkedlist_decendent.insertAtLast(temp1.Linkedlist_child.traverse(r));
				//System.out.println(temp1.Linkedlist_child.traverse(r).Linkedlist_child.linkedlist_size());
				//System.out.println(Linkedlist_decendent.traverse(r).id);
			}
	        
	        int constant_index =1;
	        int u = Linkedlist_decendent.linkedlist_size();
	       // System.out.println(Linkedlist_decendent.head.item.Linkedlist_child.linkedlist_size());
	        while(constant_index ==1 && u!=0){
				if(!Linkedlist_decendent.head.item.Linkedlist_child.linkedlist_isEmpty()){
					Node var = Linkedlist_decendent.traverse(constant_index);
					for(int a =1; a<=var.Linkedlist_child.linkedlist_size();a++){
						Linkedlist_decendent.insertAtLast(var.Linkedlist_child.traverse(a));
						u++;
				    }
					
					Linkedlist_decendent1.insertAtLast(Linkedlist_decendent.deleteAtStart());
					u--;
					
				}else if(Linkedlist_decendent.head.item.Linkedlist_child.linkedlist_isEmpty()){
					Linkedlist_decendent1.insertAtLast(Linkedlist_decendent.deleteAtStart());
					u--;
				}
		   }
	       //System.out.println(Linkedlist_decendent1.linkedlist_size());
	        int level = Linkedlist_decendent1.head.item.level;
	        Linked_list mar = new Linked_list();
	        Node cat = new Node();
	        cat.vv.add(Linkedlist_decendent1.head.item.id);
	        int m=1;
	        while(m<=Linkedlist_decendent1.linkedlist_size()){
	        	if(m==1){
	        		m++;
	        	}
	        	else{
	        		if(Linkedlist_decendent1.traverse(m).level==level){
	        			cat.vv.add(Linkedlist_decendent1.traverse(m).id);
	        			m++;
	        		}
	        		else{
	        			mar.insertAtLast(cat);
	        			Node mj = new Node();
	        			cat=mj;
	        			level=Linkedlist_decendent1.traverse(m).level;
	        		}
	        	}
	        }
	        mar.insertAtLast(cat);
	        for(int p=1;p<=mar.linkedlist_size();p++){
	        	Collections.sort(mar.traverse(p).vv);
	        }
	        
	        String ans="";
	        
	        for(int p=1;p<=mar.linkedlist_size();p++){
	        	Vector<Integer> ll = mar.traverse(p).vv;
	        	String gg="";
	        	for(int j=0;j<ll.size();j++){
	        		if(j==0){
	        			gg=gg+Integer.toString(ll.get(j));
	        		}
	        		else if(j!=0){
	        			gg=gg+" "+Integer.toString(ll.get(j));
	        		}
	        	}
	        	if(p!=mar.linkedlist_size()){
	        		gg=gg+",";
	        	}
	        	gg = gg;
	        	ans=ans+gg;
	        }
	        
	        return ans;
	        
	   } 

}

public class OrgHierarchy implements OrgHierarchyInterface{

  //root node
	Tree tree_obj = new Tree();
 
public boolean isEmpty(){
	//your implementation
	/* Returns true if the organization is empty. */
	if(tree_obj.Tree_empty()){
		return true;
	}else{
		return false;
	}
	 //throw new java.lang.UnsupportedOperationException("Not implemented yet.");	
} 

public int size(){
	//your implementation
	/* Returns the number of employees in the organization */ 
	return tree_obj.Tree_size();
	 //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
}

public int level(int id) throws IllegalIDException, EmptyTreeException{
	//your implementation
	/* Returns the level of the employee with ID=id */ 
	if(isEmpty()){
		throw new EmptyTreeException("Organization is empty");
	}else if(!tree_obj.haveEmployeeId(id)){
		throw new IllegalIDException("Invalid employee id");
	}else{
		return tree_obj.Tree_level(id);
	}
      
	 //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
} 

public void hireOwner(int id) throws NotEmptyException{
	//your implementation
	/* Adds the first employee of the organization, which we call the owner. There is only one owner 
	 * in an org who cannot be deleted. */
	if(isEmpty()){
		tree_obj.insert_owner(id);
	}
	else {
		throw new NotEmptyException("Could not be more than one hire owner");
	}
	 //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
}

public void hireEmployee(int id, int bossid) throws IllegalIDException, EmptyTreeException{
	//your implementation
	/* Adds a new employee whose ID is id. This employee will work under an existing employee 
	 * whose ID is bossid (note that this automatically decides the level of id, it is one more
	 *  than that of bossid). */
	 if(isEmpty()){
		 throw new EmptyTreeException("Without hire owner of the organization hiring of an employee is not possible");
	 }else if(!tree_obj.haveEmployeeId(bossid)){
		 throw new IllegalIDException("Invalid boss id ");
	 }
	 else if(tree_obj.haveEmployeeId(id)){
		 throw new IllegalIDException("Invalid employee id ");
	 }
	 else{
		 tree_obj.insert_employee(id, bossid);
	 }
	 
	//throw new java.lang.UnsupportedOperationException("Not implemented yet.");
} 

public void fireEmployee(int id) throws IllegalIDException,EmptyTreeException{
	//your implementation
	/* Deletes an employee who does not manage any other employees. Note that this can not be the owner.
	 *  If it is the owner, throw the IllegalIDException. */
	if(isEmpty()){
		 throw new EmptyTreeException("organization is empty");
	 }else if(!tree_obj.haveEmployeeId(id)){
		 throw new IllegalIDException("Invalid employee id ");
	 }else if(tree_obj.root1.id!= id && tree_obj.isleaf(id)){
		tree_obj.delete_leaf(id);
	 }
	 else if(!tree_obj.isleaf(id)){
		 throw new IllegalIDException(" This is boss of another employee ");
	 }
	 else{
		 throw new IllegalIDException("Owner of the organisation can be deleted ");
	 }
 	//throw new java.lang.UnsupportedOperationException("Not implemented yet.");
}
public void fireEmployee(int id, int manageid) throws IllegalIDException,EmptyTreeException{
	//your implementation
	/* Deletes an employee (id) who might manage other employees. Manageid is another employee
	 *  who works at the same level as id. All employees working under id will now work under manageid.
	 *   Note that this can not be the owner. If it is the owner, throw the IllegalIDException. */
	if(isEmpty()){
		 throw new EmptyTreeException("organization is empty");
	 }else if(!tree_obj.haveEmployeeId(id)||!tree_obj.haveEmployeeId(manageid)){
		
		 throw new IllegalIDException("Invalid employee id ");
	 }else if(tree_obj.root1.id!= id && level(id)== level(manageid)){
		tree_obj.delete_employee(id, manageid);
	 }
	 else{
		 if(level(id)!= level(manageid)){
			 throw new IllegalIDException("Invalid manage id ");
		 }
		 throw new IllegalIDException("Owner of the organisation can be deleted ");
	 }
	
	 //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
} 

public int boss(int id) throws IllegalIDException,EmptyTreeException{
	//your implementation
	/* Returns the id of the immediate boss, the employee. Output -1 if id is the owner’s ID  */
	if(isEmpty()){
		 throw new EmptyTreeException("organization is empty");
	 }else if(!tree_obj.haveEmployeeId(id)){
		 throw new IllegalIDException("Invalid employee id ");
	 }else if(tree_obj.root1.id != id){
		return tree_obj.bossId(id);
	 }else{
		 return -1;
	 }
	 //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
}

public int lowestCommonBoss(int id1, int id2) throws IllegalIDException,EmptyTreeException{
	//your implementation
	/* Returns the ID of the employee A who is a boss of both id1 and id2, and among all such persons
	 *  has the largest level. In other words, we want to find the common boss who is lowest in the hierarchy
	 *   in the company. If one of the input ids is the owner, output -1 */
	if(isEmpty()){
		 throw new EmptyTreeException(" organization is empty");
	 }else if(!tree_obj.haveEmployeeId(id1)|| !tree_obj.haveEmployeeId(id2) ){
		 throw new IllegalIDException("Invalid employee id ");
	 }else if(tree_obj.root1.id != id1 && tree_obj.root1.id != id2){
		return tree_obj.lowestCommonBossId(id1, id2);
	 }else{
		 return -1;
	 }
	// throw new java.lang.UnsupportedOperationException("Not implemented yet.");
}

public String toString(int id) throws IllegalIDException, EmptyTreeException{
	//your implementation
	/* This method returns a string that contains the IDs of all the employees of the organisation 
	 * rooted at id. It should contain the employees level-wise. So first it should have id, then ids 
	 * of all the employees directly under id, and then all employees directly these employees and so on.
	 *  Make sure that in the string levels are comma separated and employees inside a level are space separated.
	 *   Among employees at the same level, the output should be sorted in increasing order of the ids.*/
	if(isEmpty()){
		 throw new EmptyTreeException(" organization is empty");
	 }else if(!tree_obj.haveEmployeeId(id)){
		 throw new IllegalIDException("Invalid employee id ");
	 }else{
		 
		 return tree_obj.toStringEmplyee(id);
	 }
	 //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
}

}
