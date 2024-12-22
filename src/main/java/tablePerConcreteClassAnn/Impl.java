package tablePerConcreteClassAnn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Impl {

  public static void main(String[] args) {
  // Load the configuration and build the SessionFactory
  Configuration configuration = HibernateConfig.getConfig();
  configuration.addAnnotatedClass(Person.class);
  configuration.addAnnotatedClass(Employee.class);
  configuration.addAnnotatedClass(Student.class);
  ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
  		.applySettings(configuration.getProperties())
  		.build();
  SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
  System.out.println("SessionFactory created successfully.");
  // Create a session
  Session session = sessionFactory.openSession();
  Transaction transaction = null;

  
  try {
      transaction = session.beginTransaction();
      
      // Create an Employee object
      Employee employee = new Employee();
      employee.setName("John Doe");
      employee.setAddress("123 Elm Street");
      employee.setSalary(50000.0);
      employee.setTitle("Manager");

      // Create a Student object
      Student student = new Student();
      student.setName("Jane Doe");
      student.setAddress("456 Oak Avenue");
      student.setMajor("Computer Science");
      student.setGpa(3.8);

      // Save objects
      session.persist(employee);
      session.persist(student);

      transaction.commit();
  } catch (Exception e) {
      if (transaction != null) transaction.rollback();
      e.printStackTrace();
  } finally {
      session.close();
      sessionFactory.close();
  }
}
}