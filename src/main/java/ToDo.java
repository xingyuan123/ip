public class ToDo extends Task {
    public ToDo(String description) {
        super(description);
    }

    @Override
    public void printTask() {
        System.out.println("[T]" + super.getStatusIcon()  + super.getDescription() );
    }

    @Override
    public String getTextString() {
        return("T" + "|" + super.getStatusValue()  + "|" + super.getDescription() + "\n");
    }

}
