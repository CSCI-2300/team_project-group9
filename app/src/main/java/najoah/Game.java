package najoah;

import najoah.controller.*;
import najoah.model.*;

import najoah.gui.ConfirmationDialog;

public class Game 
{
     public static void main(String[] args) 
     {
          Model model = new Model();
          Controller cont = new Controller(model);  
     }
}
