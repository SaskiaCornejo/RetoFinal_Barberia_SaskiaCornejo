package com.mitocode.retofinal.exception;

import java.time.LocalDateTime;

public record CustomErrorResponse(
    LocalDateTime dateTime,
    String message,
    String Path
    )
{

}
