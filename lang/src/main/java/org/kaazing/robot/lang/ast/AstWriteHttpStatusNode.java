/*
 * Copyright (c) 2014 "Kaazing Corporation," (www.kaazing.com)
 *
 * This file is part of Robot.
 *
 * Robot is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.kaazing.robot.lang.ast;

import static org.kaazing.robot.lang.ast.util.AstUtil.equivalent;

import org.kaazing.robot.lang.ast.value.AstValue;

public class AstWriteHttpStatusNode extends AstCommandNode {

    private AstValue code;
    private AstValue reason;

    @Override
    public <R, P> R accept(Visitor<R, P> visitor, P parameter) throws Exception {
        return visitor.visit(this, parameter);
    }

    @Override
    public int hashCode() {
        int hashCode = super.hashTo();

        if (code != null) {
            hashCode <<= 4;
            hashCode ^= code.hashCode();
        }
        if (reason != null) {
            hashCode <<= 4;
            hashCode ^= reason.hashCode();
        }

        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        return (this == obj) || ((obj instanceof AstWriteHttpStatusNode) && equals((AstWriteHttpStatusNode) obj));
    }

    protected boolean equals(AstWriteHttpStatusNode that) {
        return super.equalTo(that) && equivalent(this.reason, that.reason)
                && equivalent(this.code, that.code);
    }

    @Override
    protected void formatNode(StringBuilder sb) {
        super.formatNode(sb);
        sb.append(String.format("write status %s %s\n", code, reason));
    }

    public AstValue getReason() {
        return reason;
    }

    public void setReason(AstValue reason) {
        this.reason = reason;
    }

    public AstValue getCode() {
        return code;
    }

    public void setCode(AstValue code) {
        this.code = code;
    }

}
