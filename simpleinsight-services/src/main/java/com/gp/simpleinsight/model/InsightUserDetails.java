package com.gp.simpleinsight.model;

import com.gridpulse.simpleinsight.domain.security.Permission;
import com.gridpulse.simpleinsight.domain.security.Role;
import com.gridpulse.simpleinsight.domain.security.User;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author bogdan
 */
public class InsightUserDetails
        implements UserDetails {

    private final User user;

    private List<InsightGrantedAuthority> grantedAuthorities = new ArrayList<InsightGrantedAuthority>();

    public InsightUserDetails(User user) {
        this.user = user;
        refreshAuthorities();
    }

    private void refreshAuthorities() {
        grantedAuthorities = new ArrayList<InsightGrantedAuthority>();
        for (Role role : getUser().getRoles()) {
            grantedAuthorities.add(new InsightGrantedAuthority(role));

            for (Permission p : role.getPermissions()) {
                grantedAuthorities.add(new InsightGrantedAuthority(p));
            }

        }
    }

    public String getEmailHash() {
        return md5(getUsername());
    }

    public String getDisplayName() {
        return user.getFirstName() + " " + user.getLastName();
    }

    public static String md5(String input) {
        String md5 = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(input.getBytes(), 0, input.length());
            md5 = new BigInteger(1, digest.digest()).toString(16);

        } catch (NoSuchAlgorithmException e) {
            // TODO: Log me
        }
        return md5;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    public String getPassword() {
        return user.getPassword();
    }

    public String getUsername() {
        return user.getLogin();
    }

    public boolean isAccountNonExpired() {
        return true;

    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    public User getUser() {
        return user;
    }
}
