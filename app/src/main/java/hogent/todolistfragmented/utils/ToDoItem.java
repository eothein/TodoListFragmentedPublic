package hogent.todolistfragmented.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jbuy519 on 01/09/2014.
 */
public class ToDoItem {

    private String task;
    private Date created;

    public ToDoItem(Date created, String task) {
        this.created = created;
        this.task = task;
    }

    public ToDoItem(String task){
        this.task = task;
        created = new Date(java.lang.System.currentTimeMillis());
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        String dateString = sdf.format(created);
        return "( "+dateString+") "+task;
    }
}
