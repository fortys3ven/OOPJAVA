package view;

import java.util.ArrayList;
import java.util.Arrays;
import Controller.Utils;

public abstract class Menu {

    private String title;
    private ArrayList<String> choices;

    public Menu() {
    }

    public Menu(String title, String[] mchon) {
        this.title = title;
        choices = new ArrayList<>();
        choices.addAll(Arrays.asList(mchon));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getChoices() {
        return choices;
    }

    public void setChoices(ArrayList<String> choices) {
        this.choices = choices;
    }
//----------------------------------------------------

    public void display() {
        System.out.println(title);
        System.out.println("-------------------");
        for (int i = 0; i < choices.size(); i++) {
            if (i == choices.size() - 1) {
                System.out.println("Other. " + choices.get(i));
            } else {
                System.out.println((i + 1) + ". " + choices.get(i));
            }
        }
        System.out.println("-------------------");
    }
//----------------------------------------------------

    public int getSelected() {
        display();
        int choice;
        try {
            choice = Utils.getValueInt("Enter your choice: ");
        } catch (NumberFormatException e) {
            return 0;
        }

        return choice;
    }
//----------------------------------------------------

    public abstract void execute(int ch);
//----------------------------------------------------

    public void run() {
        while (true) {
            int ch = getSelected();
            if (ch <= choices.size()) {
                execute(ch);
            } else {
                System.out.println("Exit. See you again");
                break;
            }
        }
    }
//----------------------------------------------------    
}
