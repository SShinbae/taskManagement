//@Entity
public class Task {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String title;
    public String description;
    public long dueDate;
    public boolean isCompleted;

    // Constructor, Getters, Setters
}
