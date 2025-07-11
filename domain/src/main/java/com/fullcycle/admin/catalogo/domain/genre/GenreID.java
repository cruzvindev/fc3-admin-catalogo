package com.fullcycle.admin.catalogo.domain.genre;

import com.fullcycle.admin.catalogo.domain.Identifier;
import java.util.Objects;
import java.util.UUID;

public class GenreID extends Identifier {
    private final String value;

    private GenreID(final String value){
        Objects.requireNonNull(value);
        this.value = value;
    }

    public static GenreID unique(){
        return new GenreID(UUID.randomUUID().toString().toLowerCase());
    }

    public static GenreID from(final String anId){
        return new GenreID(anId);
    }

    public static GenreID from(final UUID anId){
        return new GenreID(anId.toString().toLowerCase());
    }

    @Override
    public String getValue(){
        return value;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        final GenreID that = (GenreID) object;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
