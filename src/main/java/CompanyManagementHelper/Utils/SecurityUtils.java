package CompanyManagementHelper.Utils;

public class SecurityUtils {

  public static boolean isAdmin(String role) {
    return role.equals("Admin");
  }

  public static boolean isBoss(String role) {
    return role.equals("Szef");
  }

  public static boolean isManager(String role) {
    return role.equals("Manager") || role.equals("Kierownik");
  }

  public static boolean isWorker(String role) {
    return !isAdmin(role) && !isManager(role) && !isBoss(role);
  }
}
