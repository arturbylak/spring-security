/* Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.security.ui.switchuser;

import org.springframework.security.Authentication;
import org.springframework.security.GrantedAuthorityImpl;


/**
 * Custom <code>GrantedAuthority</code> used by {@link org.springframework.security.ui.switchuser.SwitchUserProcessingFilter}<p>Stores
 * the <code>Authentication</code> object of the original user to be used later when 'exiting' from a user switch.</p>
 *
 * @author Mark St.Godard
 * @version $Id$
 *
 * @see org.springframework.security.ui.switchuser.SwitchUserProcessingFilter
 */
public class SwitchUserGrantedAuthority extends GrantedAuthorityImpl {
    //~ Instance fields ================================================================================================

    private static final long serialVersionUID = 1L;
    private Authentication source;

    //~ Constructors ===================================================================================================

    public SwitchUserGrantedAuthority(String role, Authentication source) {
        super(role);
        this.source = source;
    }

    //~ Methods ========================================================================================================

    /**
     * Returns the original user associated with a successful user switch.
     *
     * @return The original <code>Authentication</code> object of the switched user.
     */
    public Authentication getSource() {
        return source;
    }
}