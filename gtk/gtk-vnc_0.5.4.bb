SUMMARY = "Virtual Machine Viewer"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=4339efb5fd592e45b9e2641de9fe734f"

# glib-2.0 for glib-gettext.m4 which provides AM_GLIB_GNU_GETTEXT
DEPENDS = "gtk+ glib-2.0 freetype libgcrypt gobject-introspection-stub cyrus-sasl gnutls gmp nettle"

SRC_URI = "git://git.gnome.org/browse/gtk-vnc;protocol=http \
    file://acinclude.m4"
SRCREV = "331d196ea6d03dc887b4846a2c31738c0edae501"

S = "${WORKDIR}/git"

EXTRA_OECONF += "--with-python --with-python-includes=${STAGING_INCDIR}/../ \
    PYTHON=${STAGING_BINDIR_NATIVE}/python-native/python"

SRC_URI[md5sum] = "9eb3d370c10ee8fced1b220518ebf829"
SRC_URI[sha256sum] = "d6efa3d92a1018c0683bdb2012f748b5e939e0c7dfc0941c4b246b110beb8b26"

inherit autotools-brokensep pkgconfig

# autoreconf requires ChangeLog and AUTHORS
do_configure_prepend () {
    install -m 0644 ${WORKDIR}/acinclude.m4 ${S}/

    cd ${S}
    build-aux/gitlog-to-changelog --since=2008-12-07 > ChangeLog

    out="`git log --pretty=format:'%aN <%aE>' | sort -u`" &&
    perl -p -e "s/#authorslist#// and print '$$$out'" < AUTHORS.in > AUTHORS
}

FILES_${PN} += "/usr/lib/python2.7/site-packages/*"
FILES_${PN}-dbg += "/usr/lib/python2.7/site-packages/.debug/*"
