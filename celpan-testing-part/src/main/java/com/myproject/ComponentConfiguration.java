package com.myproject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import static lombok.AccessLevel.PRIVATE;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = PRIVATE)
public class ComponentConfiguration {

    @NonNull
    private String url;
}
