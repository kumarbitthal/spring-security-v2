package kb.spsecurity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {

    private boolean status;
    private T data;
    private String errorMessage;

    public ApiResponse(T data, boolean status) {
        this.data = data;
        this.status = status;
    }

    public ApiResponse(String errorMessage, boolean status) {
        this.errorMessage = errorMessage;
        this.status = status;
    }
}
