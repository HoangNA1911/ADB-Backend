package dental_clinic.dental.Service;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;import io.jsonwebtoken.Jws;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;
@Service
public class TokenService   {
    public static final String SECRET_KEY="hoang_dep_trai_hihihi_123_456_789";
    private static final long EXPIRATION_TIME=3600000;
    public String createToken(int userId){
        return Jwts.builder().claim("USER_ID", userId)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey())
                .compact();

    }
    public String getUserIdFromToken(String token) {
        return (String) extractClaims(token).getPayload().get("USER_ID");
    }
    public boolean isTokenValid(String token) {
        String userId = this.getUserIdFromToken(token);
        return userId != null && !isTokenExpired(token);
    }
    private boolean isTokenExpired(String token) {
        return extractClaims(token).getPayload().getExpiration().before(new Date());
    }
    private Jws<Claims> extractClaims(String token) {
        return Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token);
    }
    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

}
