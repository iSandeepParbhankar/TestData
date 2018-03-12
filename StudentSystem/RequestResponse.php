<?php

class RequestResponse implements \JsonSerializable {
    private $status;
    private $payload;

    public function __construct($status, $payload)
    {
        $this->status = $status;
        $this->payload = $payload;
    }

    public function jsonSerialize()
    {
        return get_object_vars($this);
    }
}
?>