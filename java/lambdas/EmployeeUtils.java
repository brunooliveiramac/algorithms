
import java.util.function.Function;
import java.util.function.Predicate;

public class EmployeeUtils {

  public String getFullName(Employee employee) {
    Function<Employee, String> fullName = (em) -> em.getFirstName() + " " + em.getLastName();
    return fullName.apply(employee);
  }

  public String getManagersLastName(Employee employee) {
    Function<Employee, String> managersLastName = (em) -> em.getManager().getLastName();
    return managersLastName.apply(employee);
  }

  public boolean hasBeenEmployedLongerThanFiveYears(Employee employee) {
    Predicate<Employee> employedLongerThanFiveYears = em -> em.getYearsOfService() > 5;
    return employedLongerThanFiveYears.test(employee);
  }

  public boolean hasMoreThanThreeDirectReports(Employee employee) {
    Predicate<Employee> moreThanThreeDirectReports = em -> em.getNumberOfDirectReports() > 3;
    return moreThanThreeDirectReports.test(employee);
  }

  public boolean hasMoreThanThreeYearsOfServiceAndLessThanTwoDirectReports(Employee employee) {
    Predicate<Employee> moreThanThreeYearsOfServiceAndLessThanTwoDirectReports = em ->
            em.getYearsOfService() > 3 && em.getNumberOfDirectReports() < 2;
    return moreThanThreeYearsOfServiceAndLessThanTwoDirectReports.test(employee);
  }
}
