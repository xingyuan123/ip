public class Event extends Task{
    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    @Override
    public void printTask() {
        System.out.println("[E]" + super.getStatusIcon()  + super.getDescription() + "(at: " + at + ")" );
    }

    @Override
    public String getTextString() {
        return ("E" + "|" + super.getStatusValue() + "|" + super.getDescription() + "|" + at + "\n");
    }

}
