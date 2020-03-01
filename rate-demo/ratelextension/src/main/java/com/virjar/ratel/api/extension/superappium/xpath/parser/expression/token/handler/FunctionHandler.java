package com.virjar.ratel.api.extension.superappium.xpath.parser.expression.token.handler;

import com.virjar.ratel.api.extension.superappium.xpath.parser.TokenQueue;
import com.virjar.ratel.api.extension.superappium.xpath.parser.expression.SyntaxNode;
import com.virjar.ratel.api.extension.superappium.xpath.parser.expression.token.Token;
import com.virjar.ratel.api.extension.superappium.xpath.parser.expression.token.TokenHandler;
import com.virjar.ratel.api.extension.superappium.xpath.exception.XpathSyntaxErrorException;
import com.virjar.ratel.api.extension.superappium.xpath.parser.expression.FunctionParser;

public class FunctionHandler implements TokenHandler {
    @Override
    public SyntaxNode parseToken(String tokenStr) throws XpathSyntaxErrorException {
        return new FunctionParser(new TokenQueue(tokenStr)).parse();
    }

    @Override
    public String typeName() {
        return Token.FUNCTION;
    }
}
