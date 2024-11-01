package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        /*
        Создаем сервер. Вызов конструктора ServerSocket создает серверный сокет, привязанный к указанному порту.
        Чтобы клиент мог узнать, где находится сервер ему нужен адрес и порт, 9000 - это порт.
        По умолчанию адрес будет localhost.
         */
        try (ServerSocket server = new ServerSocket(9000)) {
            /*
            Сервер работает, пока его принудительно не закроют.
             */
            while (!server.isClosed()) {
                /*
                Вызов метода accept() заставляет программу ждать подключений по указанному порту, работа программы
                продолжится только после подключения клиента. После успешного подключения
                 метод возвращает объект Socket, который используется для взаимодействия с клиентом.
                 */
                Socket socket = server.accept();
                /*
                С помощью объекта Socket программа может получить входной поток
                и может отправить данные в выходной поток.
                 */
                try (OutputStream output = socket.getOutputStream();
                     BufferedReader input = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    /*
                    В ответ мы записываем строчку.
                     */
                    output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String in = input.readLine();
                    if (in.contains("/?msg=Exit")) {
                        System.out.println(in);
                        server.close();
                        break;
                    }
                    if (in.contains("?msg=Hello")) {
                        output.write("Hello".getBytes());
                        System.out.println(in);
                    } else {
                        output.write("What".getBytes());
                        System.out.println(in);
                    }
                    /*
                    В программе читается весь входной поток.
                     */
                    for (String string = input.readLine();
                         string != null && !string.isEmpty();
                         string = input.readLine()) {
                        System.out.println(string);
                    }
                    /*
                    После чтения отправляем ответ окончательно.
                     */
                    output.flush();
                } catch (Exception e) {
                    LOG.error("Input/output error", e);
                }
            }
        } catch (Exception e) {
            LOG.error("Server error", e);
        }
    }
}