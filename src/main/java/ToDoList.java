public class ToDoList {
    private int listCount;
    private String[] ToDoList;

    public ToDoList(){
        listCount = 0;
        ToDoList = new String[100];
    }


    public void addToList(String listItem){
        ToDoList[listCount] = listItem;
        listCount += 1;
    }

    public void printList(){
            System.out.println("    _____________________________________________________________");
            for(int i = 1 ; i < listCount+1 ; i++){
                System.out.println(i+":"+ ToDoList[i-1]);
            }
            System.out.println("    _____________________________________________________________");
    }

}
