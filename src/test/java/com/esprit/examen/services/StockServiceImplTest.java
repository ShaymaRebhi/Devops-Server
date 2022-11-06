//package com.esprit.examen.services;
//import java.text.ParseException;
//import java.util.List;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Order;
//import com.esprit.examen.entities.Stock;
//
//@SpringBootTest
//@TestMethodOrder(OrderAnnotation.class)
//public class StockServiceImplTest {
//    @Autowired
//    IStockService stockService;
//    private static final Logger l = LogManager.getLogger(StockServiceImpl.class);
//    @Test
//    @Order(1)
//    public void testRetrieveAllStocks() throws ParseException {
//        List<Stock> stocks = stockService.retrieveAllStocks();
//        int expected = stocks.size();
//        Stock s = new Stock("shirts",5,4);
//        Stock stock = stockService.addStock(s);
//        Assertions.assertEquals(expected + 1, stockService.retrieveAllStocks().size());
//        stockService.deleteStock(stock.getIdStock());
//    }
//    @Test
//    @Order(2)
//    public void testAddStock()throws ParseException {
//        List<Stock> stocks = stockService.retrieveAllStocks();
//        int expected=stocks.size();
//        Stock s = new Stock("stock test",10,100);
//        Stock savedStock= stockService.addStock(s);
//        Assertions.assertEquals(expected+1, stockService.retrieveAllStocks().size());
//        Assertions.assertNotNull(savedStock.getLibelleStock());
//        stockService.deleteStock(savedStock.getIdStock());
//    }
//    @Test
//    @Order(3)
//    public void testAddStockOptimized() {
//        Stock s = new Stock("stock test",10,100);
//        Stock savedStock= stockService.addStock(s);
//        Assertions.assertNotNull(savedStock.getIdStock());
//        Assertions.assertSame(10, savedStock.getQte());
//        Assertions.assertTrue(savedStock.getQteMin()>0);
//        stockService.deleteStock(savedStock.getIdStock());
//    }
//    @Test
//    @Order(4)
//    public void testDeleteStock() {
//        Stock s = new Stock("stock test",30,60);
//        Stock savedStock= stockService.addStock(s);
//        stockService.deleteStock(savedStock.getIdStock());
//        Assertions.assertNull(stockService.retrieveStock(savedStock.getIdStock()));
//    }
//}
