package com.grupo.apirest.entity.program;

import java.util.List;

public record EjercicioModel(String nombreEjercicio, List<SeriesModel> series) {}
