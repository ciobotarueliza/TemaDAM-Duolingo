package com.example.duolingo_ciobotarueliza;

import java.util.List;

public interface IResponse {
    void onSucces(List<Curs> cursuri);
    void onError(String mesaj);
}
