/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BackGround;

/**
 *
 * @author Administrator
 */
public class ClassGlobal {
    private static ClassGlobal classGlobal;
    private ClassGlobal()
    {}
    public static ClassGlobal getInstance()
    {
        if(classGlobal == null)
            classGlobal = new ClassGlobal();
        return classGlobal;
    }
    public static User GlobalUser = new User();
    public boolean loginState = false;
    public String messageToShow = null;




}
