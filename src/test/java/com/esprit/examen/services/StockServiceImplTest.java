package com.esprit.examen.services;



import java.text.ParseException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.esprit.examen.entities.Stock;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class StockServiceImplTest {
    @Autowired
    IStockService stockService;
    private static final Logger l = LogManager.getLogger(StockServiceImpl.class);

    @Test
    public void testRetrieveAllStocks() throws ParseException {

        List<Stock> stocks = stockService.retrieveAllStocks();
        int expected = stocks.size();
        Stock s = new Stock("shirts",5,4);
        Stock stock = stockService.addStock(s);
        assertEquals(expected + 1, stockService.retrieveAllStocks().size());
        stockService.deleteStock(stock.getIdStock());

    }
    @Test
    public void testAddStock()throws ParseException {
        List<Stock> stocks = stockService.retrieveAllStocks();
        int expected=stocks.size();
        Stock s = new Stock("stock test",10,100);
        Stock savedStock= stockService.addStock(s);

        assertEquals(expected+1, stockService.retrieveAllStocks().size());
        assertNotNull(savedStock.getLibelleStock());
        stockService.deleteStock(savedStock.getIdStock());

    }

    @Test
    public void testAddStockOptimized() {

        Stock s = new Stock("stock test",10,100);
        Stock savedStock= stockService.addStock(s);
        assertNotNull(savedStock.getIdStock());
        assertSame(10, savedStock.getQte());
        assertTrue(savedStock.getQteMin()>0);
        stockService.deleteStock(savedStock.getIdStock());

    }

    @Test
    public void testDeleteStock() {
        Stock s = new Stock("stock test",30,60);
        Stock savedStock= stockService.addStock(s);
        stockService.deleteStock(savedStock.getIdStock());
        assertNull(stockService.retrieveStock(savedStock.getIdStock()));
    }

}
