SUMMARY = "CLI tools for building virtual machines using libvirt"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS = "python-native"
RDEPENDS_${PN} = "libvirt virt-viewer \
    python python-urlgrabber python-subprocess python-difflib python-misc libxml2-python"

SRC_URI = "https://git.fedorahosted.org/cgit/python-virtinst.git/snapshot/virtinst-0_600_4.tar.gz"
S = "${WORKDIR}/virtinst-0_600_4"

SRC_URI[md5sum] = "4ff194418dee77afc65cfa8e277fb1e5"
SRC_URI[sha256sum] = "142c98e6cb6bdba369a1b7b5995e6828d7c2eb32f13d4be1752febd9325e43da"

inherit distutils

do_compile_prepend() {
    BUILD_SYS=${BUILD_SYS} HOST_SYS=${HOST_SYS} \
    ${STAGING_BINDIR_NATIVE}/python-native/python setup.py build ${DISTUTILS_BUILD_ARGS}
}

FILES_${PN} += "${libdir}/python2.7/site-packages"
