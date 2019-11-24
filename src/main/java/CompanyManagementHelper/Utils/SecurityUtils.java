package CompanyManagementHelper.Utils;

public class SecurityUtils {

  public static boolean isAdmin(String role) {
    return role.equals("Admin") ? true : false;
  }

  public static boolean isBoss(String role) {
    return role.equals("Szef") ? true : false;
  }

  public static boolean isManager(String role) {
    return role.equals("Manager") || role.equals("Kierownik") ? true : false;
  }

  public static boolean isWorker(String role) {
    if (!isAdmin(role) && !isManager(role) && !isBoss(role)) {
      return true;
    } else {
      return false;
    }
  }
}
