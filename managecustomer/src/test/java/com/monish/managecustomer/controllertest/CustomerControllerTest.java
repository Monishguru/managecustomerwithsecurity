/*
 * package com.monish.managecustomer.controllertest;
 * 
 * import static org.mockito.Mockito.when;
 * 
 * import org.junit.jupiter.api.Assertions; import org.junit.jupiter.api.Test;
 * import org.mockito.InjectMocks; import org.mockito.Mock; import
 * org.mockito.Mockito; import org.mockito.Spy; import
 * org.springframework.boot.test.context.SpringBootTest;
 * 
 * import com.monish.managecustomer.controller.CustomerController; import
 * com.monish.managecustomer.entity.Customer; import
 * com.monish.managecustomer.exception.InvalidInputException; import
 * com.monish.managecustomer.serviceimpl.CustomerServiceImpl;
 * 
 * @SpringBootTest public class CustomerControllerTest {
 * 
 * @InjectMocks CustomerController customerController;
 * 
 * @Spy CustomerServiceImpl customerServiceImpl;
 * 
 * @Test public void testSaveCustomer_SuccessScenario() { Customer
 * customerToSave = new Customer(); customerToSave.setId(1L);
 * customerToSave.setFirstName("Monish");
 * when(customerServiceImpl.saveCustomer(Mockito.any())).thenReturn(
 * customerToSave);
 * 
 * 
 * Customer savedCustomer = customerController.saveCustomer(customerToSave);
 * 
 * Assertions.assertEquals(savedCustomer.getFirstName(),
 * customerToSave.getFirstName());
 * 
 * }
 * 
 * @Test public void testSaveCustomer_NullCustomerScenario() { Customer
 * customerToSave = new Customer(); customerToSave.setId(1L);
 * customerToSave.setFirstName("Monish");
 * when(customerServiceImpl.saveCustomer(Mockito.any())).thenReturn(
 * customerToSave); Assertions.assertThrows(InvalidInputException.class, ()->{
 * customerController.saveCustomer(null); }); }
 * 
 * 
 * }
 */