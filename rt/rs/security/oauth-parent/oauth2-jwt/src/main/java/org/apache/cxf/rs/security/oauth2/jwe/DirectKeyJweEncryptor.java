/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.cxf.rs.security.oauth2.jwe;

import javax.crypto.SecretKey;

import org.apache.cxf.rs.security.oauth2.jwt.Algorithm;

public class DirectKeyJweEncryptor extends AbstractJweEncryptor {
    public DirectKeyJweEncryptor(SecretKey cek, byte[] iv) {
        this(new JweHeaders(Algorithm.toJwtName(cek.getAlgorithm(),
                                                cek.getEncoded().length * 8)), cek.getEncoded(), iv);
    }
    public DirectKeyJweEncryptor(JweHeaders headers, byte[] cek, byte[] iv) {
        super(headers, cek, iv);
    }
    public DirectKeyJweEncryptor(JweHeaders headers, byte[] cek, byte[] iv, int authTagLen) {
        super(headers, cek, iv, authTagLen);
    }
    protected byte[] getEncryptedContentEncryptionKey(byte[] theCek) {
        return new byte[0];
    }
}
