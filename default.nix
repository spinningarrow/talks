let pkgs = import <nixpkgs> {};

in pkgs.stdenv.mkDerivation rec {
  name = "talks";

  buildInputs = with pkgs; [
    toilet
    jq
  ];
}
