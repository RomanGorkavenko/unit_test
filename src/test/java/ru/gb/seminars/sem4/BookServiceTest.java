package ru.gb.seminars.sem4;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * 1) Почему использование тестовых заглушек может быть полезным при написании модульных тестов?
 * Это позволяет протестировать функционал тестируемого метода отдельно от остального кода.
 * 2) Какой тип тестовой заглушки следует использовать, если вам нужно проверить, что метод был вызван с определенными аргументами?
 * Mock(Spy)
 * 3) Какой тип тестовой заглушки следует использовать, если вам просто нужно вернуть определенное значение или исключение в ответ на вызов метода?
 * Mock(Spy)
 * 4) Какой тип тестовой заглушки вы бы использовали для имитации взаимодействия с внешним API или базой данных?
 * Stub(Dummy, Fake)
 */
class BookServiceTest {

    /**
     * Константа для идентификатора книги
     */
    private static final String BOOK_ID = "1";

    @Test
    void findBookById_callingMethodFindByIdFromInMemoryBookRepository_methodIsCalledOnce() {
        BookRepository mockedBookRepository = Mockito.mock(InMemoryBookRepository.class);

        BookService bookService = new BookService(mockedBookRepository);

        bookService.findBookById(BOOK_ID);

        verify(mockedBookRepository, times(1)).findById(BOOK_ID);
    }

    @Test
    void findBookById_shouldReturnTheBookById_returnBookWithRequestedId() {
        BookRepository mockedBookRepository = Mockito.spy(InMemoryBookRepository.class);

        BookService bookService = new BookService(mockedBookRepository);
        Book expected = new Book(BOOK_ID);
        Book actual = bookService.findBookById(BOOK_ID);

        assertEquals(expected.getId(), actual.getId());
    }



    @Test
    void findAllBooks_callingMethodFindAllFromInMemoryBookRepository_methodIsCalledOnce() {
        BookRepository mockedBookRepository = Mockito.mock(InMemoryBookRepository.class);

        BookService bookService = new BookService(mockedBookRepository);

        bookService.findAllBooks();

        verify(mockedBookRepository, times(1)).findAll();
    }

    @Test
    void findAllBooks_shouldReturnAllBook_returnListBooksWithSize2() {
        BookRepository mockedBookRepository = Mockito.spy(InMemoryBookRepository.class);

        BookService bookService = new BookService(mockedBookRepository);
        int expected = 2;
        List<Book> actual = bookService.findAllBooks();

        assertEquals(expected, actual.size());
    }
}