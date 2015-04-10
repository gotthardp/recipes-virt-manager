SUMMARY = "Virtual Machine Manager"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

# glib-2.0 for glib-gettext.m4 which provides AM_GLIB_GNU_GETTEXT
# intltool to provide IT_PROG_INTLTOOL
DEPENDS = "glib-2.0 intltool-native"
RDEPENDS_${PN} = "python-pygobject python-pygtk python-terminal gnome-python gtk-vnc \
    libvirt-python virtinst"

SRC_URI = "http://virt-manager.org/download/sources/virt-manager/${BP}.tar.gz"

SRC_URI[md5sum] = "2b622a0f4cd53f83665d9841b5a3cefa"
SRC_URI[sha256sum] = "5d2afb282fb8c4401f9e203dcb41a62746b9a909258d440d508219bc1a33803d"

FILES_${PN} += "/usr/share/*"

inherit autotools gettext
