package main.gateway;

import java.util.List;

public interface ReadWriter {

    <T> void updateInfo(List<T> serList, String fileName);
}
