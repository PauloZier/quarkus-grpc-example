package br.com.standard.application.port.command;

import br.com.standard.domain.port.command.Command;

public interface CommandHandler<Request extends Command, Response> {
    Response handle(Request request);
}
